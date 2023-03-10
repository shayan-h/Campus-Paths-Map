import React, {Component} from 'react';
import {pathPoints, point, segment} from "./pathPoints";

interface BuildingsState { // buildings state contains user's selection for start, end buildings and the entire list of buildings for the drop-down menus.
    start: string;
    end: string;
    buildingsList: Map<string,string>;
}

interface BuildingsProps { // building props contains a call to onchange function which takes in an array of segments.
    onChange(pathEdges: segment[]): void;
}



class Buildings extends Component<BuildingsProps, BuildingsState> {

    constructor(props: any) {
        super(props);
        const startV: string = "Start Building"
        const endV: string = "End Building"
        this.state = {
            start: startV,
            end: endV,
            buildingsList: new Map<string, string>()
        };
    }

    render() {
        const buildings = Object.values(this.state.buildingsList); // at this point, buildingsList state is updated with a hashmap of all the short building names and long building names.
        const allBuildings = Object.entries(this.state.buildingsList);
        const inverseBuildings: Map<string,string> = new Map<string, string>(); // creating an inverse buildings map so that the keys and values of this.state.buildingsList can be swapped.
        allBuildings.forEach(([key , value]) => inverseBuildings.set(value, key)); // swapping keys and values to easily access short names so that the state can be updated accurately.
        return ( // setting the state according to the correct short name corresponding to the user's selection of building long names and calling makepathrequest in find path button using start and end state's as input.
            <div id="buildings">
                <select id="select1" onChange={(event => this.setState({start: inverseBuildings.get(event.target.value) as string}))}>
                    <option id="b0">Start</option>
                    {buildings.map((building, index) => (
                        <option key={index} value={building}>{building}</option>
                    ))}
                </select>
                <select id="select2" onChange={(event => this.setState({end: inverseBuildings.get(event.target.value) as string}))}>
                    <option id="b1">End</option>
                    {buildings.map((building, index) => (
                        <option key={index} value={building}>{building}</option>
                    ))}
                </select>
                <button id="b4" onClick={() => this.makePathRequest(this.state.start, this.state.end)}>Find Path!</button>
                <button id="b5" onClick={() => {this.props.onChange([])}}>Clear Map</button>
            </div>
        );
    }

    parsePath = (text: pathPoints) => { // parsePath takes in an object of type pathPoints which is similar to a type Path in previous hw assignments and what the server sends back as a json given two building short names.
        const edges: segment[] = [];
        for (let i = 0; i < text.path.length; i++) {
            const startPoint = text.path[i].start;
            const endPoint = text.path[i].end;
            const seg: segment = {start: startPoint, end: endPoint, cost: 0}
            edges.push(seg);
        }
        this.props.onChange(edges); // calls onchange function in app.tsx
    }

    makePathRequest = async (startS: string, endS: string) => { // makepathrequest function that takes in the start building string and end building string as input (should be short names).
        try {
            let response = await fetch("http://localhost:4567/find-campus-path?start=" + startS + "&dest=" + endS); // fetches using the link from the spark server.
            if (!response.ok) {
                alert("Response is null");
                return;
            }
            let text = await response.json() as pathPoints; // since the json returned will be originally type Path<Point>, pathPoints is nearly identical to type Path<Point>.
            if (this.state.start == this.state.end) {
                alert("There is no path from a building to itself.");
                return;
            }
            console.log(this.state.start);
            console.log(this.state.end);
            console.log(text);
            this.parsePath(text);
        } catch (e) {
            alert("Error contacting the server. Please select valid buildings.");
            console.log(e);
        }
    }

    componentDidMount() { // this function is called as soon as the component mounts, this is so that makeRequest is not called more than once since we only need the list of buildings once.
        this.makeRequest();
    }

    makeRequest = async () => { // makerequest function grabs the list of buildings from the spark server.
        try {
            let response = await fetch("http://localhost:4567/buildingsList");
            if (!response.ok) {
                alert("Response is null");
                return;
            }
            let text = await response.json() as Map<string,string>; // grabs json as a map since that is what the object was before converted to a json.
            this.setState({buildingsList: text});
            console.log(text);
        } catch (e) {
            alert("Error contacting the server.");
            console.log(e);
        }
    };

}

export default Buildings;
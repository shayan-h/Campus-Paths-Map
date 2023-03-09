import React, {Component} from 'react';

interface BuildingsState {
    start: string;
    end: string;
    buildingsList: Map<string,string>;
}

interface BuildingsIn {
    shortName: string
    longName: string
}

class Buildings extends Component<BuildingsIn, BuildingsState> {

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
        const buildings = Object.values(this.state.buildingsList);
        const allBuildings = Object.entries(this.state.buildingsList);
        const inverseBuildings: Map<string,string> = new Map<string, string>();
        allBuildings.forEach(([key , value]) => inverseBuildings.set(value, key));
        return (
            <div id="buildings">
                <select id="select1" onChange={(event => this.setState({start: inverseBuildings.get(event.target.value) as string}))}>
                    <option disabled>Start</option>
                    {buildings.map((building, index) => (
                        <option key={index} value={building}>{building}</option>
                    ))}
                </select>
                <select id="select2" onChange={(event => this.setState({end: inverseBuildings.get(event.target.value) as string}))}>
                    <option disabled>End</option>
                    {buildings.map((building, index) => (
                        <option key={index} value={building}>{building}</option>
                    ))}
                </select>
                <button onClick={() => this.makePathRequest(this.state.start, this.state.end)}>Find Path!</button>
            </div>
        );
    }

    makePathRequest = async (startS: string, endS: string) => {
        try {
            let response = await fetch("http://localhost:4567/find-campus-path?start=" + startS + "&dest=" + endS);
            if (!response.ok) {
                alert("Response is null");
                return;
            }
            let text = await response.json();
            // this.setState({start: startS, end: endS});
            console.log(this.state.start);
            console.log(this.state.end);
            console.log(text);
        } catch (e) {
            alert("Error contacting the server.");
            console.log(e);
        }
    }

    componentDidMount() {
        this.makeRequest();
    }

    makeRequest = async () => {
        try {
            let response = await fetch("http://localhost:4567/buildingsList");
            if (!response.ok) {
                alert("Response is null");
                return;
            }
            let text = await response.json() as Map<string,string>;
            this.setState({buildingsList: text});
            console.log(text);
        } catch (e) {
            alert("Error contacting the server.");
            console.log(e);
        }
    };

}

export default Buildings;
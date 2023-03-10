/*
 * Copyright (C) 2022 Kevin Zatloukal and James Wilcox.  All rights reserved.  Permission is
 * hereby granted to students registered for University of Washington
 * CSE 331 for use solely during Autumn Quarter 2022 for purposes of
 * the course.  No other use, copying, distribution, or modification
 * is permitted without prior written consent. Copyrights for
 * third-party components of this work must be honored.  Instructors
 * interested in reusing these course materials should contact the
 * author.
 */

import React, {Component} from 'react';

// Allows us to write CSS styles inside App.css, any styles will apply to all components inside <App />
import "./App.css";
import Buildings from "./buildings";
import {point, segment} from "./pathPoints";
import Map from "./Map";

interface AppState { // app state is just an array of segments
    edgeData: segment[];
}

class App extends Component<{}, AppState> {

    constructor(props: {}) {
        super(props);
        this.state = {
            edgeData: []
        }
    }

    render() { // inputs the state into the onchange method in Buildings.tsx props, also updates the Map props using the array of segments.
        return (
            <div>
                <h1 id="app-title" >Campus Paths!</h1>
                <Map edgesToDraw={this.state.edgeData}/>
                <Buildings onChange={(value) => {
                    this.setState({edgeData: value});
                    console.log("EdgeList onChange", value);
                }}/>
            </div>


        );
    }

}

export default App;

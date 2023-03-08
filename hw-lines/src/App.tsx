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

import React, { Component } from "react";
import EdgeList from "./EdgeList";
import Map from "./Map";
import { ColoredEdge } from "./types";

// Allows us to write CSS styles inside App.css, any styles will apply to all components inside <App />
import "./App.css";
// import {constructor} from "react-scripts";
import edgeList from "./EdgeList";

interface AppState {
    edgeData: ColoredEdge[];
}

class App extends Component<{}, AppState> { // <- {} means no props.

  constructor(props: any) {
    super(props);
    this.state = {
      // TODO: store edges in this state
        edgeData: []
    };
  }

  render() {
    return (
      <div>
        <h1 id="app-title">Line Mapper!</h1>
        <div>
          {/* TODO: define props in the Map component and pass them in here */}
          <Map coloredEdges={this.state.edgeData}/>
        </div>
        <EdgeList
          onChange={(value) => {
            // TODO: Modify this onChange callback to store the edges in the state
              const coloredEdges: ColoredEdge[] = [];
              for (let i = 0; i < value.length; i++) {
                  const info = value[i].split(" ");
                  if (info.length != 5) { // check to see if there are 5 arguments for each line
                      alert("Not enough arguments");
                      return;
                  }
                  if ((!Number(info[0]) && info[0] != "0") || (!Number(info[1]) && info[1] != "0") || (!Number(info[2]) && info[2] != "0") || (!Number(info[3]) && info[3] != "0") || Number(info[0]) > 4000 || Number(info[1]) > 4000 || Number(info[2]) > 4000 || Number(info[3]) > 4000) {
                      alert("Arguments are not numbers or exceed the boundaries of (4000,4000)"); // check to see if arguments are numbers and whether they meet coordinate guidelines
                      return;
                  }
                  if (Number(info[0]) < 0 || Number(info[1]) < 0 || Number(info[2]) < 0 || Number(info[3]) < 0) {
                      alert("Arguments exceed the boundaries of (0,0)"); // check to see if arguments are numbers and whether they meet coordinate guidelines
                      return;
                  }
                  coloredEdges.push({ // add each edge's property to the coloredEdges
                      x1: Number(info[0]),
                      y1: Number(info[1]),
                      x2: Number(info[2]),
                      y2: Number(info[3]),
                      color: info[4]
                  })
              }
            this.setState({edgeData: coloredEdges});  // update the set
            console.log("EdgeList onChange", value);
          }}
        />
      </div>
    );
  }
}

export default App;

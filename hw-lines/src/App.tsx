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
// import edgeList from "./EdgeList";

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
              value.forEach(edge => {
                  const [x1, y1, x2, y2, color] = edge;
                  coloredEdges.push({
                      x1: Number(x1),
                      y1: Number(y1),
                      x2: Number(x2),
                      y2: Number(y2),
                      color: color
                  });
              });
            this.setState({edgeData: coloredEdges});
            console.log("EdgeList onChange", value);
          }}
        />
      </div>
    );
  }
}

export default App;

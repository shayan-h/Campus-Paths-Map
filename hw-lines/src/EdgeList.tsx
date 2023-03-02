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

interface EdgeListState {
    input: string;
}
interface EdgeListProps {
    onChange(edges: string[]): void;  // called when a new edge list is ready
                                 // TODO: once you decide how you want to communicate the edges to the App, you should
                                 // change the type of edges so it isn't `any`
}

interface EdgeType {
    x1: number, y1: number, x2: number, y2: number, color: string;
}

/**
 * A text field that allows the user to enter the list of edges.
 * Also contains the buttons that the user will use to interact with the app.
 */
class EdgeList extends Component<EdgeListProps, EdgeListState> {
    render() {
        return (
            <div id="edge-list">
                Edges <br/>
                <textarea
                    rows={5}
                    cols={30}
                    onChange={(evt) => {this.setState({input: evt.target.value})}}
                    value={this.state.input}
                /> <br/>
                <button onClick={() => {console.log('Draw onClick was called');}}>Draw</button>
                <button onClick={() => {console.log('Clear onClick was called');}}>Clear</button>
            </div>
        );
    }

    drawPressed = (text: string) => {
        const lines = text.trim().split('\n');
        const edgeList = lines.map(line => line.trim().split(' ')); // x1 y1

        // const edges: EdgeType[] = [];


        this.props.onChange(lines);
        // get specific edge values
        // props.onchange(..)

    }

}

export default EdgeList;

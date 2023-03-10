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



/**
 * A text field that allows the user to enter the list of edges.
 * Also contains the buttons that the user will use to interact with the app.
 */
class EdgeList extends Component<EdgeListProps, EdgeListState> {

    constructor(props: any) {
        super(props);
        const text: string = "Enter coordinates";
        this.state = {
            input: text
        }
    }
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
                <button onClick={() => {this.drawPressed(this.state.input)}}>Draw</button>
                <button onClick={() => {this.setState({input:""}); this.props.onChange([])}}>Clear</button>
            </div>
        );
    }

    drawPressed = (text: string) => { // draw pressed function for when the draw button is pressed
        const lines = text.trim().split('\n');


        this.props.onChange(lines);
        // get specific edge values
        // props.onchange(..)

    }

}

export default EdgeList;

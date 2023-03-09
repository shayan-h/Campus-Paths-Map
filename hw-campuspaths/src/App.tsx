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

class App extends Component<{}, {}> {

    constructor(props: {}) {
        super(props);
    }

    render() {
        return (
            <div>
                <h1 id="app-title" >Line Mapper!</h1>
                <Buildings shortName={"short"} longName={"long"}/>
            </div>


        );
    }

}

export default App;

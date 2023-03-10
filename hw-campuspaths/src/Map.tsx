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

import { LatLngExpression } from "leaflet";
import React, { Component } from "react";
import { MapContainer, TileLayer } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import MapLine from "./MapLine";
import { UW_LATITUDE_CENTER, UW_LONGITUDE_CENTER } from "./Constants";
import {point, segment} from "./pathPoints";

// This defines the location of the map. These are the coordinates of the UW Seattle campus
const position: LatLngExpression = [UW_LATITUDE_CENTER, UW_LONGITUDE_CENTER];

// NOTE: This component is a suggestion for you to use, if you would like to. If
// you don't want to use this component, you're free to delete it or replace it
// with your hw-lines Map

interface MapProps { // map props contains an array of segments.
  // TODO: Define the props of this component.
    edgesToDraw: segment[];
}

interface MapState {}

class Map extends Component<MapProps, MapState> {
  render() { // creates a JSX element array which is then filled with type MapLine and the MapLine props are filled with the proper values contained in the segment array that correspond to x1, x2, y1, y2 (start, end) and the color is hard coded to black.
      let edgeLines: JSX.Element[] = [];
      for (let i = 0; i < this.props.edgesToDraw.length; i++) {
          edgeLines.push(<MapLine color={"black"} x1={this.props.edgesToDraw[i].start.x}
                                  y1={this.props.edgesToDraw[i].start.y} x2={this.props.edgesToDraw[i].end.x} y2={this.props.edgesToDraw[i].end.y}/>)
      }
    return (
      <div id="map">
        <MapContainer
          center={position}
          zoom={15}
          scrollWheelZoom={false}
        >
          <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          {
            // TODO: Render map lines here using the MapLine component. E.g.
            // <MapLine key="key1" color="red" x1={1000} y1={1000} x2={2000} y2={2000}/>
            // will draw a red line from the point 1000,1000 to 2000,2000 on the
            // map. Note that key should be a unique key that only this MapLine has.
              edgeLines
          }
        </MapContainer>
      </div>
    );
  }
}

export default Map;

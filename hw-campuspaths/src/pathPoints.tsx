export interface pathPoints {
    cost: number
    start: point
    path: segment[]

}

export interface point {
    x: number
    y: number
}

export interface segment {
    start: point
    end: point
    cost: number
}
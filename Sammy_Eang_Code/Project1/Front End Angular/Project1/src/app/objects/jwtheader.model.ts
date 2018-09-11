export class jwtheader {

    typ: string;
    alg: string;

    constructor(type, algorithm) {
        this.typ = type;
        this.alg = algorithm;
    }
}
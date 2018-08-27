export class Reimbursement {
    ReimbId: number;
    ReimbAmount: number;
    DateSubmitted: number;
    DateResolved: number;
    Description: string;
    Author: number;
    Resolver: number;
    Type: number;
    Status: number;

    constructor(reimbid, reimbamount, datesubmit, dateresolve, descrip, author, resolver, type, status) {
        this.ReimbId = reimbid;
        this.ReimbAmount = reimbamount;
        this.DateSubmitted = datesubmit;
        this.DateResolved = dateresolve;
        this.Description = descrip;
        this.Author = author;
        this.Resolver = resolver;
        this.Type = type;
        this.Status = status;
    }
}

export class jwtpayload {

    username: string;
    pw: string;
    secret: string;

    constructor(uname, password, sec) {
        this.username = uname;
        this.pw = password;
        this.secret = sec;
    }
}
export class Employee {
    emp_id: number;
    username: string;
    pw: string;
    first_name: string;
    last_name: string;
    email: string;
    role: number;

    constructor(id, username, pw, fname, lname, email, role) {
        this.emp_id = id;
        this.username = username;
        this.pw = pw;
        this.first_name = fname;
        this.last_name = lname;
        this.email = email;
        this.role = role;
    }
}

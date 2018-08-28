export class Todo {
    task: string;
    completed = false;

    constructor(task, completed) {
        this.task = task;
        this.completed = completed;
    }
}

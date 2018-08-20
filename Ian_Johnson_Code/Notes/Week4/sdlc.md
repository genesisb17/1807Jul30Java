# SDLC (Software Development Lifecycle)

The SDLC is a process used by the tech industry to design, develop and test
high-quality software. The standard model consists of the following steps
(which are circular; after the last step you loop back to the first):

1. Plan: gather requirements.
2. Define: get scope of project clearly defined.
3. Design: decide best plan of attack to accomplish goal (architectural
   design, etc.).
4. Build: code.
5. Test: test code, fix bugs.
6. Deploy: deploy to production.

This is the standard lifecycle, but other models exist.

- Big Bang ("everything all at once")
  - No formal dev process
  - OK for small projects
  - Requires a lot of management overhead
- Iterative ("building a village")
  - Add requirements modularly
  - No defined finish line
  - Pros: better feedback, flexibility
  - Cons: high management overhead, time management
- Waterfall ("building a bridge")
  - Well-defined requirements which do not change
  - Good for large teams; used often in government
  - Pros: little management overhead
  - Cons: lack of flexibility
- _Agile_ ("it's a way of life" - Martin Fowler)
  - Modular, testable, flexible, trackable
  - Learn from previous "sprints" and adapt

## Agile

The Agile model separates business requirements into "user stores" (e.g. "As
a _, I can _ so that \_"). These user stores are relatively easy units of
work and independent of incomplete components. They are assigned to specific
team members and assigned point values based on time or effort required.
Progress for each user story is tracked in a burndown chart.

Daily standup meetings are held, each of which should be at least 15 minutes
long. In these meetings, developers discuss what they have accomplished the
day before, what they plan to accomplish the next day and any potential
blockers for those goals.

- Scrum
  - The project is usually broken into 2 or 3-week sprints. User stores not in a
    spring end up in the "backlog". Sprints begin with planning and end with
    a review.
- Kanban
  - User stores are split into "epics". "Swimlanes" are used to manage stories
    moving at different paces or with varying urgency. This uses longer
    iterations than Scrum.

Common tools used for Agile management are Jira, Confluence, Taiga, Pivotal
Tracker and Trello.

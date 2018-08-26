import { UserRole } from './user-role.enum';

/**
 * An interface corresponding to the user data sent from the server.
 */
export class User {
  id: number;
  role: UserRole;
  username: string;
  firstName: string;
  lastName: string;
  email: string;
}

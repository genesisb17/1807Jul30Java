export enum UserRole {
  Employee = 'EMPLOYEE',
  Manager = 'MANAGER',
}

export namespace UserRole {
  /**
   * Parses a UserRole from a string.
   *
   * @param s the string to be parsed as a (case-insensitive) type value
   */
  export function parse(s: string): UserRole | null {
    if (!s) {
      return null;
    }
    switch (s.toLowerCase()) {
      case 'employee':
        return UserRole.Employee;
      case 'manager':
        return UserRole.Manager;
      default:
        return null;
    }
  }

  /**
   * Formats a UserRole in a user-readable string.
   *
   * @param r the UserRole to format
   */
  export function format(r: UserRole): string {
    if (!r) {
      return '';
    }
    return r.charAt(0).toUpperCase() + r.substring(1).toLowerCase();
  }
}

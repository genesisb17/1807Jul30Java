export enum ReimbursementStatus {
  Pending = 'PENDING',
  Approved = 'APPROVED',
  Denied = 'DENIED',
}

// To simulate adding static methods to an enum in TypeScript:
export namespace ReimbursementStatus {
  /**
   * Parses a ReimbursementStatus from a string.
   *
   * @param s the string to be parsed as a (case-insensitive) status value
   */
  export function parse(s: string): ReimbursementStatus | null {
    if (!s) {
      return null;
    }
    switch (s.toLowerCase()) {
      case 'pending':
        return ReimbursementStatus.Pending;
      case 'approved':
        return ReimbursementStatus.Approved;
      case 'denied':
        return ReimbursementStatus.Denied;
      default:
        return null;
    }
  }

  /**
   * Formats a ReimbursementStatus as a user-readable string.
   *
   * @param s the ReimbursementStatus to format
   */
  export function format(s: ReimbursementStatus): string {
    if (!s) {
      return '';
    }
    return s.charAt(0).toUpperCase() + s.substring(1).toLowerCase();
  }
}
import { ReimbursementType } from './reimbursement-type.enum';
import { ReimbursementStatus } from './reimbursement-status.enum';
import { Decimal } from 'decimal.js';

export class Reimbursement {
  id: number;
  type: ReimbursementType;
  status: ReimbursementStatus;
  amount: Decimal;
  description?: string;
  authorId: number;
  resolverId?: number;
  submitted: Date;
  resolved?: Date;
}

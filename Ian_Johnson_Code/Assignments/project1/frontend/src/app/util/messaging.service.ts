import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

/**
 * A service that allows messages to be sent to different channels and
 * retrieved through observables.
 */
@Injectable({
  providedIn: 'root',
})
export class MessagingService {
  private subjects: { [name: string]: Subject<string> } = {};

  constructor() {}

  /**
   * Gets an observable for the messages in the given channel.
   *
   * @param channel the name of the channel
   */
  getMessages(channel: string): Observable<string> {
    // Create the subject if it doesn't exist.
    if (!(channel in this.subjects)) {
      this.subjects[channel] = new Subject();
    }
    return this.subjects[channel];
  }

  /**
   * Sends a message to the given channel.
   *
   * @param channel the channel to which to send the message
   * @param message the message to send
   */
  send(channel: string, message: string): void {
    // Create the subject if it doesn't exist.
    if (!(channel in this.subjects)) {
      this.subjects[channel] = new Subject();
    }
    this.subjects[channel].next(message);
  }
}

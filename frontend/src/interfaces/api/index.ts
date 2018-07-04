import * as Payload from '../payloads'

export default interface Api {
  getPolls: () => Promise<Payload.Polls>
}
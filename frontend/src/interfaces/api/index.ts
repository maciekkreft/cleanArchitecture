import * as Payload from '../payloads'

export default interface Api {
  getPolls: () => Promise<Payload.Polls>
  postInit: () => Promise<string>
  postAnswers: (answers: Payload.Answers) => Promise<Payload.Answers>
  getResults: () => Promise<Payload.Results>
  getSupplements: () => Promise<Payload.Supplements>
}
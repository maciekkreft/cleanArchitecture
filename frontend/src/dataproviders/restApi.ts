import axios from 'axios'

import { Api, Payload } from '../interfaces'

export class RestApi implements Api {
  public async getPolls(): Promise<Payload.Polls> {
    return (await axios.get('/polls')).data
  }
}
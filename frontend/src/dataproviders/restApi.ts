import fetch from 'axios'
const axios = fetch.create({
  baseURL: 'http://localhost:8080',
  withCredentials: true
})

import { Api, Payload } from '../interfaces'

export class RestApi implements Api {

  public async getPolls(): Promise<Payload.Polls> {
    return (await axios.get('/polls')).data
  }

  public async postInit(): Promise<string> {
    return (await axios.post('/init')).data
  }
}
import fetch from 'axios'
const axios = fetch.create({
  // baseURL: 'http://localhost:8080',
  withCredentials: true,
})

import { Api, Payload } from '../interfaces'

export class RestApi implements Api {

  public async getPolls(): Promise<Payload.Polls> {
    return (await axios.get('/polls')).data
  }

  public async postInit(): Promise<string> {
    return (await axios.post('/init')).data
  }

  public async postAnswers(answers: Payload.Answers): Promise<Payload.Answers> {
    return (await axios.post('/sheets', answers)).data
  }

  public async getResults(): Promise<Payload.Results> {
    return (await axios.get('/results')).data
  }

  public async getSupplements(): Promise<Payload.Supplements> {
    return (await axios.get('/supplements')).data
  }
}
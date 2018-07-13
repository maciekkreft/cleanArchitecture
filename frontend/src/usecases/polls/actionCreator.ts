import { Dispatch } from 'redux'

import { Api, Payload } from '../../interfaces'

export const GET_POLLS_REQUEST = 'GET_POLLS_REQUEST'
export type GET_POLLS_REQUEST = typeof GET_POLLS_REQUEST

export const GET_POLLS_RESPONSE = 'GET_POLLS_RESPONSE'
export type GET_POLLS_RESPONSE = typeof GET_POLLS_RESPONSE

export const GET_POLLS_FAILURE = 'GET_POLLS_FAILURE'
export type GET_POLLS_FAILURE = typeof GET_POLLS_FAILURE

export interface GetPollsRequest { type: GET_POLLS_REQUEST }

export interface GetPollsResponse {
  type: GET_POLLS_RESPONSE, payload: Payload.Polls
}

export interface GetPollsFailure { type: GET_POLLS_FAILURE }

export type GetPollsActions = GetPollsRequest
  | GetPollsResponse | GetPollsFailure

export const getPolls = (dispatch: Dispatch<GetPollsActions>) => (api: Api) => {
  dispatch({ type: GET_POLLS_REQUEST })
  return api.getPolls().then(
    (payload: Payload.Polls) => dispatch({
      type: GET_POLLS_RESPONSE,
      payload
    }),
    error => dispatch({
      type: GET_POLLS_FAILURE
    })
  )
}
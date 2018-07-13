import { Dispatch } from 'redux'

import { Api, Payload } from '../../interfaces'

export const GET_RESULTS_REQUEST = 'GET_RESULTS_REQUEST'
export type GET_RESULTS_REQUEST = typeof GET_RESULTS_REQUEST

export const GET_RESULTS_RESPONSE = 'GET_RESULTS_RESPONSE'
export type GET_RESULTS_RESPONSE = typeof GET_RESULTS_RESPONSE

export const GET_RESULTS_FAILURE = 'GET_RESULTS_FAILURE'
export type GET_RESULTS_FAILURE = typeof GET_RESULTS_FAILURE

interface GetResultsRequest { type: GET_RESULTS_REQUEST }
interface GetResultsResponse { type: GET_RESULTS_RESPONSE, payload: Payload.Results }
interface GetResultsFailure { type: GET_RESULTS_FAILURE }
export type GetResultsAction = GetResultsRequest
  | GetResultsResponse | GetResultsFailure

export const getResults = (dispatch: Dispatch<GetResultsAction>) => (api: Api) => {
  dispatch({ type: GET_RESULTS_REQUEST })
  return api.getResults().then(
    (payload: Payload.Results) => dispatch({ type: GET_RESULTS_RESPONSE, payload }),
    (error) => dispatch({ type: GET_RESULTS_FAILURE })
  )
}
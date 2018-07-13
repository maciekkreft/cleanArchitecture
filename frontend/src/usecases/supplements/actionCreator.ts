import { Dispatch } from 'redux'

import { Api, Payload } from '../../interfaces'

export const GET_SUPPLEMENTS_REQUEST = 'GET_SUPPLEMENTS_REQUEST'
export type GET_SUPPLEMENTS_REQUEST = typeof GET_SUPPLEMENTS_REQUEST
export const GET_SUPPLEMENTS_RESPONSE = 'GET_SUPPLEMENTS_RESPONSE'
export type GET_SUPPLEMENTS_RESPONSE = typeof GET_SUPPLEMENTS_RESPONSE
export const GET_SUPPLEMENTS_FAILURE = 'GET_SUPPLEMENTS_FAILURE'
export type GET_SUPPLEMENTS_FAILURE = typeof GET_SUPPLEMENTS_FAILURE

export interface GetSupplementsRequest { type: GET_SUPPLEMENTS_REQUEST }
export interface GetSupplementsResponse {
  type: GET_SUPPLEMENTS_RESPONSE, payload: Payload.Supplements
}
export interface GetSupplementsFailure { type: GET_SUPPLEMENTS_FAILURE }

export type GetSupplementsActions = GetSupplementsRequest
  | GetSupplementsResponse | GetSupplementsFailure

export const getSupplements = (
  dispatch: Dispatch<GetSupplementsActions>
) => (api: Api) => {
  dispatch({ type: GET_SUPPLEMENTS_REQUEST })
  return api.getSupplements().then(
    (payload: Payload.Supplements) => dispatch({
      type: GET_SUPPLEMENTS_RESPONSE,
      payload
    }),
    error => dispatch({
      type: GET_SUPPLEMENTS_FAILURE
    })
  )
}
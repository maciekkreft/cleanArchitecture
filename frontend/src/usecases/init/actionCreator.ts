import { Dispatch } from 'redux'

import { Api } from '../../interfaces'

export const POST_INIT_REQUEST = 'POST_INIT_REQUEST'
export type POST_INIT_REQUEST = typeof POST_INIT_REQUEST

export const POST_INIT_RESPONSE = 'POST_INIT_RESPONSE'
export type POST_INIT_RESPONSE = typeof POST_INIT_RESPONSE

export const POST_INIT_FAILURE = 'POST_INIT_FAILURE'
export type POST_INIT_FAILURE = typeof POST_INIT_FAILURE

export interface GetInitRequest { type: POST_INIT_REQUEST }
export interface GetInitResponse { type: POST_INIT_RESPONSE, payload: string }
export interface GetPollsFailure { type: POST_INIT_FAILURE }

export type GetInitActions = GetInitRequest
  | GetInitResponse | GetPollsFailure

export const postInit = (dispatch: Dispatch<GetInitActions>) => (api: Api) => {
  dispatch({ type: POST_INIT_REQUEST })
  return api.postInit().then(
    (payload) => dispatch({
      type: POST_INIT_RESPONSE,
      payload
    }),
    error => dispatch({
      type: POST_INIT_FAILURE
    })
  )
}
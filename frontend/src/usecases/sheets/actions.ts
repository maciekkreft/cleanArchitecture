import { Dispatch } from 'redux'

import { Action, Api, Payload } from '../../interfaces'

export const ADD_ANSWER = 'ADD_ANSWER'
export type ADD_ANSWER = typeof ADD_ANSWER

export interface AddAnswer { type: ADD_ANSWER, payload: Action.AnswerPayload }
export type AddAnswerAction = AddAnswer

export const addAnswer = (dispatch: Dispatch<AddAnswerAction>) =>
  (payload: Action.AnswerPayload) => {
    dispatch({ type: ADD_ANSWER, payload })
  }


export const POST_ANSWERS_REQUEST = 'POST_ANSWERS_REQUEST'
export type POST_ANSWERS_REQUEST = typeof POST_ANSWERS_REQUEST

export const POST_ANSWERS_RESPONSE = 'POST_ANSWERS_RESPONSE'
export type POST_ANSWERS_RESPONSE = typeof POST_ANSWERS_RESPONSE

export const POST_ANSWERS_FAILURE = 'POST_ANSWERS_FAILURE'
export type POST_ANSWERS_FAILURE = typeof POST_ANSWERS_FAILURE

export interface PostAnswersRequest { type: POST_ANSWERS_REQUEST }
export interface PostAnswersResponse { type: POST_ANSWERS_RESPONSE }
export interface PostAnswersFailure { type: POST_ANSWERS_FAILURE }

export type PostAnswersAction = PostAnswersRequest
  | PostAnswersResponse | PostAnswersFailure

export const postAnswers = (dispatch: Dispatch<PostAnswersAction>) => (api: Api) => (answers: Payload.Answers) => {
  dispatch({ type: POST_ANSWERS_REQUEST })
  return api.postAnswers(answers).then(
    (payload) => dispatch({ type: POST_ANSWERS_RESPONSE }),
    (error) => dispatch({ type: POST_ANSWERS_FAILURE })
  )
}
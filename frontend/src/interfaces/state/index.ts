export interface Polls {
  byCode: {
    [p: string]: Poll
  },
  codes: string[]
}

export interface Poll {
  code: string
  name: string
  category: string
  questions: string[]
  mediumScore: number
  highScore: number
}

export default interface State {
  polls: Polls
}
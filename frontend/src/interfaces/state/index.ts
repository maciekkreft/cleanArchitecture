export interface Categories {
  byCode: {
    [p: string]: Category
  },
  codes: string[]
}

export interface Category {
  code: string
  name: string
}

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
  polls: Polls,
  categories: Categories,
  initialized: boolean
}
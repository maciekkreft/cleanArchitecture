interface Category {
  code: string
  name: string
}

interface Question {
  [index: number]: string
}

interface Answer {
  [index: number]: boolean
}

interface Poll {
  code: string
  name: string
  category: Category
  questions: Question[]
  mediumScore: number
  highScore: number
}

export type Polls = Poll[]

export interface Answers {
  pollCode: string
  answers: Answer[]
}

export interface Result {
  version: number
  pollCode: string
  deficiency: 'LOW' | 'MEDIUM' | 'HIGH'
  createdAt: Date
}

export type Results = Result[]

export interface Supplement {
  code: string
  name: string
  dose: string
  dosing: string
}

export type Supplements = Supplement[]
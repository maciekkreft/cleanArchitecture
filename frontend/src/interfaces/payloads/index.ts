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

export interface Answers {
  pollCode: string
  answers: Answer[]
}

export type Polls = Poll[]

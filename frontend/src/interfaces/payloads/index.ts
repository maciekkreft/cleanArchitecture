interface Category {
  code: string
  name: string
}

interface Question {
  [p: number]: string
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

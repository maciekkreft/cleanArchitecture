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
  supplements: string[]
  mediumScore: number
  highScore: number
}

export interface Sheets {
  byCode: {
    [pollCode: string]: Sheet
  }
}

export interface Sheet {
  [index: number]: boolean
}

export interface Result {
  version: number
  pollCode: string
  deficiency: 'LOW' | 'MEDIUM' | 'HIGH'
  createdAt: string
}

export interface Results {
  byCodeAndVersion: {
    [pollCodeAndVersion: string]: Result
  }
}

export interface Supplement {
  code: string
  name: string
  dose: string
  dosing: string
}

export interface Supplements {
  byCode: {
    [code: string]: Supplement
  }
}


export default interface State {
  polls: Polls,
  categories: Categories,
  sheets: Sheets,
  results: Results,
  supplements: Supplements,
  initialized: boolean
}

interface Poll {
  code: string
  name: string
  category: string
  questions: string[]
  mediumScore: number
  highScore: number
}

export default interface State {
  polls: {
    byCode: {
      [p: string]: Poll
    },
    codes: string[]
  }
}
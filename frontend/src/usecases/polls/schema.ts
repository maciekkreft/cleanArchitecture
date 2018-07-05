import { normalize, schema } from 'normalizr'

import { Payload, State } from '../../interfaces'

const category = new schema.Entity('categories', {}, {
  idAttribute: 'code'
})

const poll = new schema.Entity('polls', { category }, {
  idAttribute: 'code'
})

interface Normalized {
  entities: {
    polls: State.Polls['byCode']
    categories: State.Categories['byCode']
  },
  result: string[]
}

export default (payload: Payload.Polls): Normalized =>
  normalize(payload, [poll])
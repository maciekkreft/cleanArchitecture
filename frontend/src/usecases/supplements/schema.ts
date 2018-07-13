import { normalize, schema } from 'normalizr'

import { Payload, State } from '../../interfaces'

const supplement = new schema.Entity('supplements', {}, {
  idAttribute: 'code'
})

interface Normalized {
  entities: {
    supplements: State.Supplements['byCode']
  },
  result: string[]
}

export default (payload: Payload.Supplements): Normalized =>
  normalize(payload, [supplement])
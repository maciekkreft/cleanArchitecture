import { normalize, schema } from 'normalizr'

import { Payload, State } from '../../interfaces'

const result = new schema.Entity('results', {}, {
  idAttribute: (r: Payload.Result) => r.pollCode + '-' + r.version
})

interface Normalized {
  entities: {
    results: State.Results['byCodeAndVersion']
  },
  result: string[]
}

export default (payload: Payload.Results): Normalized =>
  normalize(payload, [result])
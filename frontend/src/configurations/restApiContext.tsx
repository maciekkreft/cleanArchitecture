import * as React from 'react'

import { ApiContext } from '../contexts'
import { RestApi } from '../dataproviders'

export default ({ children }: { children: JSX.Element }) => (
  <ApiContext.Provider value={new RestApi()}>
    {children}
  </ApiContext.Provider>
)
import * as React from 'react'
import { Header, Navigation, PollsList } from '../containers'

export const PollListScreen = () =>
  <React.Fragment>
    <Header />
    <PollsList />
    <Navigation />
  </React.Fragment>
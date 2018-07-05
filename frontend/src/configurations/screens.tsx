import * as React from 'react'
import { Header, Navigation, PollsList, PollWithSheet } from '../containers'

export const PollListScreen = () =>
  <React.Fragment>
    <Header />
    <PollsList />
    <Navigation />
  </React.Fragment>


export const PollScreen = () =>
  <React.Fragment>
    <Header />
    <PollWithSheet />
    <Navigation />
  </React.Fragment>
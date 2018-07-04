import * as React from 'react'
import { Footer, Header, PollList } from '../containers'

export const PollListScreen = () =>
  <React.Fragment>
    <Header />
    <PollList />
    <Footer />
  </React.Fragment>
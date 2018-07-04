import * as React from 'react'

import {
  BottomNavigation,
  BottomNavigationAction,
  withStyles
} from '@material-ui/core'

import {
  Assignment as PollsIcon,
  TrendingUp as ResultsIcon
} from '@material-ui/icons'

const styles: any = {
  root: {
    bottom: 0,
    position: 'fixed',
    width: '100%',
  },
}

// tslint:disable-next-line:interface-name
interface Props {
  classes: any;
}

class SimpleBottomNavigation extends React.Component<Props, object> {
  public state = {
    value: 0,
  }

  public render() {
    const { classes } = this.props
    const { value } = this.state

    return (
      <BottomNavigation
        value={value}
        onChange={this.handleChange}
        showLabels={true}
        className={classes.root}
      >
        <BottomNavigationAction label="Ankiety" icon={<PollsIcon />} />
        <BottomNavigationAction label="Wyniki" icon={<ResultsIcon />} />
      </BottomNavigation>
    )
  }

  private handleChange = (event: any, value: any) => {
    this.setState({ value })
  }
}

export const BottomNavigationComponent = withStyles(styles)(SimpleBottomNavigation)
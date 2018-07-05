import * as React from 'react'

import {
  List,
  ListItem,
  ListItemText,
  ListSubheader,
  withStyles,
} from '@material-ui/core'

const styles = (theme: any) => ({
  nested: {
    paddingLeft: theme.spacing.unit * 0,
  },
  root: {
    backgroundColor: theme.palette.background.paper,
    width: '100%',
  },
})

interface Props {
  classes: any
}

class NestedList extends React.Component<Props> {
  public render() {
    const { classes } = this.props

    return (
      <div className={classes.root}>
        <List
          component="nav"
          subheader={
            <ListSubheader component="div">
              Odzywienie
            </ListSubheader>
          }
        >
          <ListItem button={true}>
            <ListItemText primary="Serotonina" />
          </ListItem>
          <ListItem button={true}>
            <ListItemText primary="Dopamina" />
          </ListItem>
        </List>
      </div>
    )
  }
}

export const NestedListComponent = withStyles(styles)(NestedList)

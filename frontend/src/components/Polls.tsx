import * as React from 'react'

import { State } from '../interfaces'

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
  categories: State.Categories
  pollsByCategories: { [c: string]: State.Poll[] }
}

class NestedList extends React.Component<Props> {
  public render() {
    const { classes, categories, pollsByCategories }: Props = this.props

    return (
      <div className={classes.root}>
        {
          categories.codes.map(c => (
            < List
              key={c}
              component="nav"
              subheader={
                <ListSubheader component="div" disableSticky={true}>
                  {categories.byCode[c].name}
                </ListSubheader>
              }
            >
              {
                pollsByCategories[c].map(p =>
                  <ListItem key={p.code} button={true}>
                    <ListItemText primary={p.name} />
                  </ListItem>
                )
              }
            </List>
          ))
        }
        <br />
        <br />
        <br />
      </div>
    )
  }
}

export const PollsComponent = withStyles(styles)(NestedList)

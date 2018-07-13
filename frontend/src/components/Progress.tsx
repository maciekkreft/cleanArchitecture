import * as React from 'react'

import {
  Card, CardHeader, List, ListItem, ListItemText, withStyles
} from '@material-ui/core'

interface StyleProps {
  classes: any
}

const styles: any = {
  card: {
    marginTop: 10,
    textAlign: 'center'
  },
}

interface Props {
  classes: any
}

function Progress(props: Props) {
  const { classes } = props
  return (
    <div>
      <Card className={classes.card}>
        <CardHeader title='Your progress over time' />
      </Card>
      <Card className={classes.card}>
        <List>
          <ListItem>
            <ListItemText primary='Serotonin' />
          </ListItem>
          <ListItem> <ListItemText secondary='1 day ago - low deficiency level' /> </ListItem>
          <ListItem> <ListItemText secondary='1 week ago - medium deficiency level' /> </ListItem>
          <ListItem> <ListItemText secondary='1 month ago - high deficiency level' /> </ListItem>
        </List>
      </Card>
      <Card className={classes.card}>
        <List>
          <ListItem>
            <ListItemText primary='Dopamine' />
          </ListItem>
          <ListItem> <ListItemText secondary='1 day ago - low deficiency level' /> </ListItem>
          <ListItem> <ListItemText secondary='1 week ago - medium deficiency level' /> </ListItem>
          <ListItem> <ListItemText secondary='1 month ago - high deficiency level' /> </ListItem>
        </List>
      </Card>
      <br />
      <br />
      <br />
    </div>
  )
}

export const ProgressComponent = withStyles(
  styles
)<Partial<StyleProps> & Props>(Progress)
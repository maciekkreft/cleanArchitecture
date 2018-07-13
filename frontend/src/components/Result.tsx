import * as React from 'react'

import {
  Card, CardContent, CardHeader, List, ListItem, ListItemText, Typography, withStyles
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

function Result(props: Props) {
  const { classes } = props
  return (
    <div>
      <Card className={classes.card}>
        <CardHeader title='Your deficiency is very high' />
        <CardContent>
          <Typography component='p'>You should consider using supplementation</Typography>
        </CardContent>
      </Card>
      <Card className={classes.card}>
        <List>
          <ListItem>
            <ListItemText primary='Melatonin' secondary='1 x 1mg' />
          </ListItem>
          <ListItem>
            <Typography component='p'>Take 1 capsule one hour before sleep</Typography>
          </ListItem>
        </List>
      </Card>
      <Card className={classes.card}>
        <List>
          <ListItem>
            <ListItemText primary='Tryptophan' secondary='2 x 250mg' />
          </ListItem>
          <ListItem>
            <Typography component='p'>Take 1 capsule two times a day</Typography>
          </ListItem>
        </List>
      </Card>
      <br />
      <br />
      <br />
    </div>
  )
}

export const ResultComponent = withStyles(
  styles
)<Partial<StyleProps> & Props>(Result)
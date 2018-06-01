import React from 'react';
import {storiesOf} from '@storybook/react';
import Search from "../../src/components/presentations/templates/Search";

storiesOf('templates/Search', module)
    .add('default', () => <Search/>);
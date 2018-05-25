import React from 'react';
import {storiesOf} from '@storybook/react';
import SearchForm from "../../src/components/presentations/organisms/SearchForm";

storiesOf('organisms/SearchForm', module)
    .add('default', () => <SearchForm/>);
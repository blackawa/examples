import React from 'react';

const SearchResult = ({repositories}) => {

  const borderColor = '#aaa';

  const tableCellStyle = {
    fontSize: '.9rem',
    border: `solid 1px ${borderColor}`,
    padding: '0.25rem',
  };

  const repositoryRows = repositories ? repositories.map(r => <tr>
    <td style={tableCellStyle}>{r.name}</td>
    <td style={tableCellStyle}>{r.url}</td>
  </tr>) : null;

  return <table style={{border: `solid 1px ${borderColor}`, borderCollapse: 'collapse'}}>
    <thead>
    <tr>
      <th style={tableCellStyle}>Name</th>
      <th style={tableCellStyle}>URL</th>
    </tr>
    </thead>
    <tbody>
    {repositoryRows}
    </tbody>
  </table>
};

export default SearchResult
// src/Posts.js
import React from 'react';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  // Step 6: Load posts from API
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => this.setState({ posts: data }))
      .catch((error) => {
        console.error('Error fetching posts:', error);
        this.setState({ hasError: true });
      });
  }

  // Step 7: Lifecycle method to call API
  componentDidMount() {
    this.loadPosts();
  }

  // Step 9: Lifecycle hook to catch rendering errors
  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert('Something went wrong while displaying posts!');
    console.error('Error details:', error, info);
  }

  // Step 8: Render UI
  render() {
    if (this.state.hasError) {
      return <h2 style={{ color: 'red' }}>An error occurred while rendering.</h2>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;

```python
import tensorflow as tf

```


```python
# create tensors
#tensor-rank0
tensorrank0=tf.constant(4)
#createtensor-rank-1 :
tensorrank1=tf.constant([1.0,2.0,3])
print(tensorrank0)
print(tensorrank1)
```

    tf.Tensor(4, shape=(), dtype=int32)
    tf.Tensor([1. 2. 3.], shape=(3,), dtype=float32)
    


```python
#create tensor rank 2 i mean with 2 dim matrix
tf.constant([[1.2,3.6],[1.6,8]],dtype=tf.float16)
```




    <tf.Tensor: shape=(2, 2), dtype=float16, numpy=
    array([[1.2, 3.6],
           [1.6, 8. ]], dtype=float16)>




```python
# create a tensor rank 3
# There can be an arbitrary number of
# axes (sometimes called "dimensions")
rank_3_tensor= tf.constant([
  [[0, 1, 2, 3, 4],
   [5, 6, 7, 8, 9]],
  [[10, 11, 12, 13, 14],
   [15, 16, 17, 18, 19]],
  [[20, 21, 22, 23, 24],
   [25, 26, 27, 28, 29]],])

print(rank_3_tensor)
```

    tf.Tensor(
    [[[ 0  1  2  3  4]
      [ 5  6  7  8  9]]
    
     [[10 11 12 13 14]
      [15 16 17 18 19]]
    
     [[20 21 22 23 24]
      [25 26 27 28 29]]], shape=(3, 2, 5), dtype=int32)
    


```python
hello =tf.constant('Hello')
```


```python
const1= tf.constant(' world!')
```


```python
result=hello+const1
```


```python
import tensorflow.compat.v1 as tf
tf.disable_v2_behavior()
```


```python
with tf.Session() as sess:
  result1=sess.run(result)
```


```python
print(result1)
#It's a way of expressing a sequence of bytes the b in the first
```

    b'Hello world!'
    


```python
#Using sesssion for evaluate tensors
with tf.Session() as sess :
  print(sess.run(result))
```

    b'Hello world!'
    


```python
type(hello)
```




    tensorflow.python.framework.ops.SymbolicTensor



#####  Tensors operations :


```python
tensor1=tf.constant(2)
tensor2=tf.constant(4)
resultt=tensor1+tensor2
with tf.Session() as sess:
    result12=print(sess.run(resultt))
```

    6
    


```python
tensor1=tf.constant([[2],[5]])
tensor2=tf.constant([[7,7]])
resultat=tf.matmul(tensor1,tensor2)
```


```python
with tf.Session() as sess :
  print(sess.run(resultat))
```

    [[14 14]
     [35 35]]
    


```python
print(resultat)
```

    Tensor("MatMul:0", shape=(2, 2), dtype=int32)
    


```python
# we can create a tensor with zeros values :


# Create a tensor with zeros values of shape [3, 7] and data type tf.int32
zeros_tensor = tf.zeros([3, 7], dtype=tf.int32)

# Print the tensor
with tf.Session( ) as sess:
    print(sess.run(zeros_tensor))


```

    [[0 0 0 0 0 0 0]
     [0 0 0 0 0 0 0]
     [0 0 0 0 0 0 0]]
    


```python
#create a tensor with ones values
ones_tensor = tf.ones([3, 7], dtype=tf.int32)
print(ones_tensor)
#affiche it in a session
with tf.Session() as sess:
  print(sess.run(ones_tensor))
```

    Tensor("ones:0", shape=(3, 7), dtype=int32)
    [[1 1 1 1 1 1 1]
     [1 1 1 1 1 1 1]
     [1 1 1 1 1 1 1]]
    


```python
# write a def of session for evaluate tensors
def evaluate(tensor):
  with tf.Session() as sess:
    result = sess.run(tensor)
  return result     # Evaluate the tensor and return the result
    
```


```python
#with diff between tf.constant et tf.fill :   tf.fill is more flexible
#tf.fill evaluates at graph runtime and supports dynamic shapes based on other runtime tf.Tensors, unlike tf.constant(value, shape=dims), which embeds the value as a Const node.
 #create a tensor with fill values
fill_tensor = tf.fill([3, 7], 9)
print(fill_tensor)
#affiche it in a session
with tf.Session() as sess:
  print(sess.run(fill_tensor))
```

    Tensor("Fill:0", shape=(3, 7), dtype=int32)
    [[9 9 9 9 9 9 9]
     [9 9 9 9 9 9 9]
     [9 9 9 9 9 9 9]]
    


```python
#create a tensor with random values : 
myrand=tf.random_normal([3,7])
#what hapeen if i did not put the mean and std of the tensor: myrand=tf.random_normal([3,7],mean=0,stddev=1)
#affiche it in a session
with tf.Session() as sess:
  print(sess.run(myrand))
```

    [[-0.09612381  1.6913769   1.1047078   1.7178066   1.2083716   0.30906072
      -1.348729  ]
     [ 0.6857748  -0.38278764 -0.74179727 -0.11248467  0.54572964  0.38961023
       0.16705896]
     [-0.13360627 -0.362666   -0.4920014  -1.2581354  -0.89914244 -0.48219693
      -0.03723804]]
    


```python
#create a random uniform tensor
myrand=tf.random_uniform([3,7])
#affiche it in a session
with tf.Session() as sess:
  print(sess.run(myrand))
  
```

    [[0.24012768 0.08665705 0.66841197 0.7336587  0.6692089  0.13790476
      0.5257356 ]
     [0.6566038  0.30531144 0.43316305 0.60338676 0.84155977 0.80458975
      0.62545574]
     [0.1889627  0.48783052 0.69847476 0.7153318  0.07365179 0.39740133
      0.70208204]]
    


--> En TensorFlow, session.run() et evaluate() sont deux façons de calculer les valeurs de tenseurs dans un modèle.
* --> Cependant, il y a des différences subtiles entre les deux.

~
 $ En TensorFlow, session.run() et evaluate() sont deux façons de calculer les valeurs de tenseurs dans un modèle. Cependant, il y a des différences subtiles entre les deux.
~


```python
#write the code to qhow the default graph  
dg=tf.get_default_graph() 
print(tf.get_default_graph())
```

    <tensorflow.python.framework.ops.Graph object at 0x000002165B7F2A60>
    


```python
g=tf.Graph()
print(g)
```

    <tensorflow.python.framework.ops.Graph object at 0x000002165B7F2B80>
    


```python
g is tf.get_default_graph()
```




    False



Qu'est-ce que les graphes ?
Dans les trois guides précédents, vous avez exécuté TensorFlow de manière interactive (eager execution). Cela signifie que les opérations TensorFlow sont exécutées par Python, opération par opération, et les résultats sont renvoyés à Python.

Bien que l'exécution interactive présente plusieurs avantages uniques, l'exécution de graphes permet la portabilité en dehors de Python et offre généralement de meilleures performances. L'exécution de graphes signifie que les calculs de tenseurs sont effectués sous la forme d'un graphe TensorFlow, parfois appelé tf.Graph ou simplement "graphique".

Les graphes sont des structures de données qui contiennent un ensemble d'objets tf.Operation, qui représentent des unités de calcul ; et des objets tf.Tensor, qui représentent les unités de données qui circulent entre les opérations. Ils sont définis dans un contexte tf.Graph. Étant donné que ces graphes sont des structures de données, ils peuvent être sauvegardés, exécutés et restaurés sans le code Python d'origine.

Voici à quoi ressemble un graphe TensorFlow représentant un réseau neuronal à deux couches lorsqu'il est visualisé dans TensorBoard :

Un graphe TensorFlow simple : ![Image](https://github.com/tensorflow/docs/blob/master/site/en/guide/images/intro_to_graphs/two-layer-network.png?raw=1)


##### Eager vs Graph Execution

Eager execution: execution of Python code without a graph

Graph execution: computations done using a graph

Example: function to add two numbers in Python is eager execution; if passed to `tf.function` and run on a graph, it's graph execution

#####  What is a Graph?

Consists of nodes and edges

Nodes: where operations happen (e.g. addition, dot product)

Edges: values passed between nodes (in tensor objects)

Values flow in one direction

##### Benefits of Graphs:

TensorFlow creates a graph with a function

Graphs can run faster and more efficiently than eager execution

Can run in parallel and on multiple devices

Can be used on environments without Python (e.g. TensorFlow Lite)

Can be optimized more easily

##### Coding Part :

Libraries used: TensorFlow, timeit, datetime

`tf.function`

Converts Python functions to a graph

Can work on nested functions

Uses autograph to bridge between Python and TensorFlow

Branching in Graphs

Branches created based on conditional statements in Python functions (e.g. if-else)

`tf.constant` used to input values to the function

##### Polymorphism :

One function can create multiple graphs based on data type and shape of input

Different graphs stored within the concrete function in TensorFlow


```python
tf.version
```




    <module 'tensorflow._api.v2.version' from '/usr/local/lib/python3.10/dist-packages/tensorflow/_api/v2/version/__init__.py'>




```python
tf.convert_to_tensor(
   3, dtype=None, dtype_hint=None, name=None
) #-> tf.Tensor
```




    <tf.Tensor: shape=(), dtype=int32, numpy=3>




```python

```

`Also w can convert a  multitypes to tensors --> Converts the given value to a Tensor`


```python
#original rep a frame of an image
original = tf.constant([[[1.0, 2.0, 3.0]]])
converted = tf.image.rgb_to_grayscale(original)
print(converted.numpy())
```

    [[[1.8149]]]
    


```python
import tensorflow as tf

# Assuming you have a color image tensor with dimensions (height, width, channels)
color_image = tf.random.normal(shape=(256, 256, 3))

# Convert the color image to grayscale
grayscale_image = tf.image.rgb_to_grayscale(color_image)

# Print the shapes of the original and grayscale images
print("Original image shape:", color_image.shape)
print("Grayscale image shape:", grayscale_image.shape)

```

    Original image shape: (256, 256, 3)
    Grayscale image shape: (256, 256, 1)
    
